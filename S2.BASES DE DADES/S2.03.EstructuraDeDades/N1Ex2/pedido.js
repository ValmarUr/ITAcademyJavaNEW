
db.createCollection('pedido', {
    validator: {
        $jsonSchema: {
            bsonType: 'object',
            title:'pedido',
            required: ['fecha_hora_pedido', 'tipo_pedido', 'cantidad_productos', 'precio_total', 'producto', 'cliente', 'tienda'],
            properties: {
                fecha_hora_pedido: {bsonType: 'timestamp'},
                tipo_pedido: {enum: ['domicilio', 'recoger']},
                cantidad_productos: {bsonType: 'int'},
                precio_total: {bsonType: 'double'},
                producto: {bsonType: 'array',items: {bsonType: 'objectId'}},
                cliente: {bsonType: 'objectId'},
                tienda: {bsonType: 'objectId'},
                empleado: {bsonType: 'objectId'},
                fecha_hora_entrega: {bsonType: 'timestamp'}
            }
        }
    }
});  