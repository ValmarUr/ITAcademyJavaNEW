
db.createCollection('empleado', { 
    validator: { 
        $jsonSchema: { 
            bsonType: 'object', 
            title: 'empleado', 
            required: ['nombre', 'apellido', 'nif', 'telefono', 'empleo', 'tienda'], 
            properties: { 
                nombre: { bsonType: 'string' }, 
                apellido: { bsonType: 'string' }, 
                nif: { bsonType: 'int' }, 
                telefono: { bsonType: 'int' }, 
                empleo: { enum: ['cocinero', 'repartidor'] }, 
                tienda: { bsonType: 'objectId' } 
            } 
        } 
    } 
});  