
db.createCollection('producto', {
    validator: {
        $jsonSchema: {
            bsonType: 'object',
            title:'producto',
            required: ['tipo', 'nombre', 'descripcion', 'precio'],
            properties: {
                tipo: {enum: ['pizza', 'hamburguesa', 'bebida']},
                nombre: {bsonType: 'string'},
                descripcion: {bsonType: 'string'},
                imagen: {bsonType: 'binData'},
                precio: {bsonType: 'double'},
                categoria_pizza: {bsonType: 'objectId'}
            } 
        }
    }
});  