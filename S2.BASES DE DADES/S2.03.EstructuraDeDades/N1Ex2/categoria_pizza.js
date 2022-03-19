
db.createCollection('categoria_pizza', { 
    validator: { 
        $jsonSchema: { 
            bsonType: 'object', 
            title: 'categoria_pizza', 
            required: ['nombre'], 
            properties: { 
                nombre: { bsonType: 'string' } 
            } 
        } 
    } 
});  