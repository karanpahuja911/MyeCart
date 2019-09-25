select r.region_name as Region,
s.state_name as State,
c.city_name as City,
sc.center_name as DC,
employee_code as 'FE Code',
concat(firstname, ' ', lastname) as 'FE Name',
group_concat(distinct dos.id) as 'DRS Nos.',
min(dos.added_on) as 'DRS Creation TS',
min(ds.added_on) as 'First Shipment Added to DRS',
max(ds.added_on) as 'Last Shipment Added to DRS',
min(ds.updated_on) as 'First Shipment Updated on',
max(ds.updated_on) as 'Last Shipment Updated on',
count(distinct ds.shipment_id) 'Total Shipments Assigned',
count(distinct case when (ds.status=1) then ds.shipment_id else null end) 'Successfull',
count(distinct case when (ds.status=2) then ds.shipment_id else null end) 'Failed',
concat(round(count(distinct case when (ds.status=1) then ds.shipment_id else null end) / count(distinct ds.shipment_id)*100,2),'') as 'Success percentage',
TIMESTAMPDIFF(MINUTE, min(ds.updated_on),max(ds.updated_on)) / count(distinct ds.shipment_id) as 'Minutes/Shipment'
from service_centre_deliveryoutscan dos inner join service_centre_doshipment ds on ds.deliveryoutscan_id = dos.id
inner join service_centre_shipment sh on sh.id = ds.shipment_id
inner join location_servicecenter sc on sc.id = dos.origin_id
                                        inner join location_city c on c.id = sc.city_id
                                        inner join location_state s on s.id = c.state_id
                                        inner join location_region r on r.id = c.region_id
inner join authentication_employeemaster e on e.id = dos.employee_code_id
                                        
where sh.rts_status<>1
and dos.added_on>date_sub(CURDATE(), interval 1 day)
and dos.added_on < CURDATE()
group by 1,2,3,4,5,6
having count(distinct case when (ds.status=1) then ds.shipment_id else null end) / count(distinct ds.shipment_id) <=0.1;
