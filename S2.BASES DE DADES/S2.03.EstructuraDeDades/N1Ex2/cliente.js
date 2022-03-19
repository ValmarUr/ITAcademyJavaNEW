
db.createCollection('cliente', {
    validator: {
        $jsonSchema: {
            bsonType: 'object', 
            title: 'cliente', 
            required: ['nombre', 'apellido', 'contacto', 'telefono'], 
            properties: {
                nombre: { bsonType: 'string' }, 
                apellido: { bsonType: 'string' }, 
                contacto: {
                    bsonType: 'object',
                    title: 'contacto', 
                    required: ['direccion', 'CP', 'localidad', 'provincia'], 
                    properties: { 
                        direccion: { bsonType: 'string' }, 
                        CP: { bsonType: 'int' }, 
                        localidad: { bsonType: 'objectId' }, 
                        provincia: { bsonType: 'objectId' } }
                }, telefono: { bsonType: 'int' }
            }
        }
    }
});  