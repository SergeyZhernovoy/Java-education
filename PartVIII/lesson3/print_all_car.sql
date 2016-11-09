SELECT 
	car.name AS "car name",
	engine.name AS "engine brand",
	box.name AS "gear brand",
	trans.name AS "transm. name"

FROM car AS car

LEFT OUTER JOIN engine AS engine
ON car.engine_id = engine.engine_id

LEFT OUTER JOIN gear_box AS box
ON car.box_id = box.gear_box_id

LEFT OUTER JOIN transmission AS trans
ON car.transm_id = trans.transmission_id
  