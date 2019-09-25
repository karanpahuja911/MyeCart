select 
main.Outscan_date_d_m_y as 'Outscan Date',
main.employee_code_id as 'Employee_ID',
main.ecode as 'Employee_Code',
main.user as 'Designation',
main.fname as 'First_Name',
main.lname as 'Last_Name',
main.DC as 'DC',
main.City as 'City',
main.state as 'State',
main.region as 'Region',
sum(main.Fwd_vol) as 'Forward_Outscan_Vol',
sum(main.Fwd_Delv) as 'Fwd_Delv_Vol',
sum(main.Saathi_Delv) as 'SAATHi_Delv_Vol',
sum(main.rts_vol) as 'RTS_Vol',
sum(main.rts_Delv) as 'RTS_Delv_Vol',
sum(main.eds_vol) as 'EDS_Vol',
sum(main.eds_pickup_completed) as 'EDS_Pickup_Completed',
sum(main.rvp_pickup_vol) as 'RVP_Pickup_Vol',
sum(main.rvp_pickup_completed) as 'RVP_Pickup_Completed',
sum(main.rvp_outscan_vol) as 'RVP_Outscan_Vol',
sum(main.rvp_delv_vol) as 'RVP_Delv_Vol'


from(

select 
scdo.deliveryoutscan_id,
sc.id,
sc.airwaybill_number as 'awb',
sc.rts_status,
sc.reverse_pickup,
sc.rto_status,
scde.status as 'status(0-1)', 
scdo.status as 'status(0-2)',

@sathi_status :=  ifnull((select drs1.status   from integration_services_drscommit drs1 where  drs1.awb_no = sc.airwaybill_number  and drs1.status in (9) and drs1.added_on = scdo.updated_on  order by assign_date desc limit 1),'') sathi_status ,

case when sc.rts_status in (0,2) and sc.reverse_pickup = 0 then 1 else 0 end 'Fwd_vol',
(case when scdo.status = 1 and sc.rts_status in (0,2) and sc.reverse_pickup = 0 and date(scdo.added_on) = date(scdo.updated_on) then 1 else 0 end) as 'Fwd_Delv',
(case when scdo.status = 1 and sc.rts_status in (0,2) and sc.reverse_pickup = 0  and @sathi_status = 9 and date(scdo.added_on) = date(scdo.updated_on) then 1 else 0 end) as 'Saathi_Delv',

case when sc.rts_status  = 1 then 1 else 0 end 'rts_vol',
(case when scdo.status = 1 and sc.rts_status in (1) and date(scdo.added_on) = date(scdo.updated_on) then 1 else 0 end) as 'rts_Delv',

case when sc.reverse_pickup = 1 and sc.product_type = 'eds' and (scdo.added_on <= sc.inscan_date or sc.inscan_date is null) then 1 else 0 end 'eds_vol',
(case when scdo.status = 1 and sc.reverse_pickup = 1 and sc.product_type = 'eds' and (scdo.added_on <= sc.inscan_date or sc.inscan_date is null) and date(scdo.added_on) = date(scdo.updated_on) then 1 else 0 end) as 'eds_pickup_completed',

case when sc.reverse_pickup = 1 and sc.product_type <> 'eds' and (scdo.added_on <= sc.inscan_date or sc.inscan_date is null)    then 1 else 0 end 'rvp_pickup_vol',
(case when scdo.status = 1 and sc.reverse_pickup = 1 and sc.product_type <> 'eds' and scdo.added_on <= sc.inscan_date and date(scdo.added_on) = date(scdo.updated_on) then 1 else 0 end) as 'rvp_pickup_completed',


case when sc.reverse_pickup = 1 and sc.product_type <> 'eds' and scdo.added_on > sc.inscan_date then 1 else 0 end 'rvp_outscan_vol',
(case when scdo.status = 1 and sc.reverse_pickup = 1 and sc.product_type <> 'eds' and scdo.added_on > sc.inscan_date and date(scdo.added_on) = date(scdo.updated_on) then 1 else 0 end) as 'rvp_delv_vol',

sc.inscan_date,



scdo.added_on as 'outscan_time',
date_format(scdo.added_on, '%d-%M-%Y') as 'Outscan_date_d_m_y',


scdo.updated_on as 'outscan_status_update_time',
scde.updated_on as 'DRS close time',
scdo.shipment_id,
scde.employee_code_id,
ae.user_type as 'user',
ae.employee_code as 'ecode', 
 ae.firstname as 'fname', 
 ae.lastname as 'lname',
lsc.center_shortcode as 'DC',
lc.city_name as 'City',
ls.state_shortcode as 'state',
#lr.region_name as 'region'
CASE WHEN ls.id IN (8,9,14,22) Then 'Central' else lr.region_name END as 'Region'

  
  from service_centre_doshipment scdo
  inner join service_centre_deliveryoutscan scde on scde.id = scdo.deliveryoutscan_id
  left join service_centre_shipment sc on scdo.shipment_id = sc.id
  left join authentication_employeemaster ae on ae.id = scde.employee_code_id
  
  left JOIN location_servicecenter lsc ON lsc.id = scde.origin_id
  left join location_city lc on lc.id = lsc.city_id
  left join location_state ls on ls.id = lc.state_id
  left join location_region lr on lr.id = lc.region_id

where 1=1
  
 and scdo.added_on >= '2019-09-24'
and scdo.added_on < '2019-09-25'
#and sc.rts_status in (0,2)
#and sc.reverse_pickup = 0
and sc.shipper_id not in (12)
#and lsc.center_shortcode in ('DEP')
#and ae.employee_code in ('PT716','PT700','PT712','PT711','PT692','PT691','PT690','PT689','PT688','PT687','PT686','PT685')
)main
where 1=1 
 group by 
 main.Outscan_date_d_m_y,
main.employee_code_id,
main.DC
