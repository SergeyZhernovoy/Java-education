SELECT 
engine.name AS name,
engine.engine_id AS id,
'engine' AS "type details"

FROM engine AS engine 
LEFT OUTER JOIN car AS car  
ON engine.engine_id = car.engine_id
WHERE car.engine_id is NULL

UNION

SELECT 
box.name AS name,
box.gear_box_id AS id,
'gear box' AS "type details"

FROM gear_box AS box 
LEFT OUTER JOIN car AS car  
ON  box.gear_box_id = car.box_id
WHERE car.box_id is NULL

UNION

SELECT 
transm.name AS name,
transm.transmission_id AS id,
'transmission' AS "type details"

FROM transmission AS transm 
LEFT OUTER JOIN car AS car  
ON  transm.transmission_id = car.transm_id
WHERE car.transm_id is NULL