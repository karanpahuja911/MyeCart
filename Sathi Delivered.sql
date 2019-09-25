select TRIM(ship_latest_outscan_emp) emp_code,
       TRIM(concat(TRIM(ifnull(firstname,'')),' ', TRIM(ifnull(lastname,'')))) emp_name,
       ship_latest_inscan_dc_sc dc_code,
       DATE(s.ship_latest_status_update_time) delivery_date, 
       COUNT(DISTINCT s.awb) shipment_count,
       COUNT(DISTINCT case when (NOT IFNULL(lm.shipment_id,drs.status) is null ) then s.awb else Null end) delivered_via_sathi
from service_centre_shipment sh inner join reports_shipmentbaghistory s on sh.airwaybill_number = s.awb
                  left join location_servicecenter l_dst on s.ship_latest_inscan_dc_sc = l_dst.center_shortcode
                  left join location_city c_dst on c_dst.id = l_dst.city_id
                  left join authentication_employeemaster em on em.employee_code = s.ship_latest_outscan_emp
                  left join api_shipmentlastmileupdate lm on lm.shipment_id = sh.id and lm.status=9
                  left join integration_services_drscommit drs on drs.awb_no = s.awb and drs.status=9 
  where 1=1
  and sh.updated_on >= date_sub(CURDATE(), INTERVAL 7 DAY) #'2017-08-23'
  and sh.updated_on < CURDATE()
  and sh.status = 9
  and sh.rts_status = 0
  and sh.reverse_pickup<>1
  and sh.product_type<>'rev'
  and sh.shipper_id <>12
  and TRIM(ship_latest_outscan_emp) in (select employee_code from authentication_employeemaster where employee_code like 'PT%' or employee_code like 'DP%')
group by TRIM(ship_latest_outscan_emp) ,
         TRIM(concat(TRIM(ifnull(firstname,'')),' ', TRIM(ifnull(lastname,'')))) ,
         ship_latest_inscan_dc_sc ,
         DATE(s.ship_latest_status_update_time);