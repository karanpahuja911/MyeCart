select qry1.Date, IFNULL(qry1.Location,qry2.Location), qry1.`Overall Outscan`, qry1.`Overall % Delivered`, qry1.`Fresh Outscan`, qry1.`Fresh % Delivered`, qry1.`RAD Outscan`, qry1.`RAD % Delivered`, qry2.`Overall 1st Outscan`, qry2.`Overall FAD%`, qry2.`Prepaid 1st Outscan`, qry2.`Prepaid FAD%`, qry2.`COD 1st Outscan`, qry2.`COD FAD%` 
from

(select  qry.ship_status_date as 'Date',
        qry.DC as Location,
		count(qry.AWB) as 'Overall Outscan',
        ifnull(round(((count(qry.AWB_Delvd)/count(qry.AWB))*100),2),0) as 'Overall % Delivered',
		count(case when qry.Attempts>=1 then qry.fresh_outscan_awb else null end) as 'Fresh Outscan',
        ifnull(round(((count(case when qry.Attempts>=1 then qry.AWB_Delvd else null end)/count(case when qry.Attempts>=1 then qry.fresh_outscan_awb else null end))*100),2),0) as 'Fresh % Delivered',
        count(case when qry.Attempts > 1 then qry.AWB else null end) as 'RAD Outscan',
        ifnull(round(((count(case when qry.Attempts > 1 then qry.AWB_Delvd else null end)/count(case when qry.Attempts > 1 then qry.AWB else null end))*100),2),0) as 'RAD % Delivered'
from


(select 
		sh.airwaybill_number as 'AWB',
        date(scde.updated_on) as 'ship_status_date',
		lsc.center_shortcode 'DC',
		(select count(date(scde.added_on)) from service_centre_doshipment scdo inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id where sh.id = scdo.shipment_id and scde.origin_id = sh.service_centre_id ) as 'Attempts',
        @fresh_outscan := (select max(scde.added_on) from service_centre_doshipment scdo inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id where sh.id = scdo.shipment_id and scde.origin_id = sh.service_centre_id order by scde.id desc limit 1) as 'first_outscan',
        (select sh.airwaybill_number from service_centre_doshipment scdo inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id where sh.id = scdo.shipment_id and scde.origin_id = sh.service_centre_id and scde.added_on = @fresh_outscan order by scde.id desc limit 1) as 'fresh_outscan_awb',
		(case when scdo.status = 1 then sh.airwaybill_number else null end) as 'AWB_Delvd'
					 
		from service_centre_doshipment scdo inner join service_centre_shipment sh on scdo.shipment_id = sh.id           
											inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id
											left join location_servicecenter lsc on lsc.id = scde.origin_id
		
		
		
		where 1=1
				#and scde.updated_on >= case when subdate(current_date(),weekday(current_date())) = current_date() then subdate(date_sub(current_date(), interval 1 day),weekday(date_sub(current_date(), interval 1 day))) else  subdate(current_date(),weekday(current_date())) end
				and scde.updated_on >= case when subdate(current_date(),weekday(current_date())) = current_date() then subdate(date_sub(current_date(), interval 1 day),weekday(date_sub(current_date(), interval 1 day))) else  subdate(current_date(),weekday(current_date())) end
                and scde.updated_on < current_date()
				and sh.rts_status in (0,2)
				and sh.reverse_pickup <> 1
				and sh.shipper_id NOT in (12)
				and sh.product_type != 'eds'
				and sh.expected_dod is not null

		group by 1
	) qry 
    
group by 1,2) qry1 inner join

#First Attempt Delivery(FAD) Rate
(select  qry.ship_status_date as 'Date',
          qry.DC as Location,
		count(case when qry.Attempts=1 then qry.first_outscan_awb else null end) as 'Overall 1st Outscan',
        ifnull(round(((count(case when qry.Attempts=1 then qry.AWB_Delvd else null end)/count(case when qry.Attempts=1 then qry.first_outscan_awb else null end))*100),2),0) as 'Overall FAD%',
		
        count(case when qry.Attempts=1 and qry.product_type = 'ppd' then qry.first_outscan_awb else null end) as 'Prepaid 1st Outscan',
        ifnull(round(((count(case when qry.Attempts=1 and qry.product_type = 'ppd' then qry.AWB_Delvd else null end)/count(case when qry.Attempts=1 and qry.product_type = 'ppd' then qry.first_outscan_awb else null end))*100),2),0) as 'Prepaid FAD%',
        
        count(case when qry.Attempts=1 and qry.product_type = 'cod' then qry.first_outscan_awb else null end) as 'COD 1st Outscan',
        ifnull(round(((count(case when qry.Attempts=1 and qry.product_type = 'cod' then qry.AWB_Delvd else null end)/count(case when qry.Attempts=1 and qry.product_type = 'cod' then qry.first_outscan_awb else null end))*100),2),0) as 'COD FAD%'
        
from


(select 
		sh.airwaybill_number as 'AWB',
        sh.product_type,
        date(scde.updated_on) as 'ship_status_date',
		lsc.center_shortcode 'DC',
		(select count(date(scde.added_on)) from service_centre_doshipment scdo inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id where sh.id = scdo.shipment_id and scde.origin_id = sh.service_centre_id ) as 'Attempts',
        @first_outscan := (select min(scde.added_on) from service_centre_doshipment scdo inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id where sh.id = scdo.shipment_id and scde.origin_id = sh.service_centre_id order by scde.id desc limit 1) as 'first_outscan',
        (select sh.airwaybill_number from service_centre_doshipment scdo inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id where sh.id = scdo.shipment_id and scde.origin_id = sh.service_centre_id and scde.added_on = @first_outscan order by scde.id desc limit 1) as 'first_outscan_awb',
		(case when scdo.status = 1 then sh.airwaybill_number else null end) as 'AWB_Delvd'
					 
		from service_centre_doshipment scdo inner join service_centre_shipment sh on scdo.shipment_id = sh.id           
											inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id
											left join location_servicecenter lsc on lsc.id = scde.origin_id
		
		
		
		where 1=1
				and scde.updated_on >= case when subdate(current_date(),weekday(current_date())) = current_date() then subdate(date_sub(current_date(), interval 1 day),weekday(date_sub(current_date(), interval 1 day))) else  subdate(current_date(),weekday(current_date())) end
                and scde.updated_on < current_date()
                and sh.rts_status in (0,2)
				and sh.reverse_pickup <> 1
				and sh.shipper_id NOT in (12)
				and sh.product_type != 'eds'
				and sh.expected_dod is not null

		group by 1
	) qry         
group by 1,2) qry2 on qry1.Date = qry2.Date;