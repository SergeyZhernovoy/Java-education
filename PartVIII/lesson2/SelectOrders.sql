--выберем ордера на продажу в статусе новый

SELECT  
	listOrders.order_id, 
	listOrders.date_order, 
	listOrders.number_order, 
	Type.name, 
	Status.name 
FROM orders as listOrders
INNER JOIN type_order as Type 
ON listOrders.type_id = Type.type_id
INNER JOIN status_order as Status 
ON listOrders.status_id = Status.status_id
WHERE Status.status_id = 1 AND Type.name = 'sale';
