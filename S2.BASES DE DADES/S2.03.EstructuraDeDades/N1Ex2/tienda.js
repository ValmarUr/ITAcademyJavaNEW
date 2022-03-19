
db.createCollection('tienda', {
    validator: {
        $jsonSchema: {
            bsonType: 'object',
            title:'tienda',
            required: ['contacto'],
            properties: {
                contacto: {
                    bsonType: 'object',
                    title:'contacto',
                    required: ['direccion', 'CP', 'localidad', 'provincia'],
                    properties: {
                        direccion: {bsonType: 'string'},
                        CP: {bsonType: 'int'},
                        localidad: {bsonType: 'objectId'},
                        provincia: {bsonType: 'objectId'}
                    }
                }
            }
        }
    }
});  