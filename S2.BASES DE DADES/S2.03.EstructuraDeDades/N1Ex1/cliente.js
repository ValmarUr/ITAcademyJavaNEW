
db.createCollection('cliente',
    {
        validator:
        {
            $jsonSchema:
            {
                bsonType: 'object', title: 'cliente',
                required: ['nombre', 'codigo_postal', 'e_mail', 'fecha_registro'],
                properties: {
                    nombre: { bsonType: 'string' },
                    codigo_postal: { bsonType: 'string' },
                    e_mail: { bsonType: 'string' },
                    fecha_registro: { bsonType: 'date' },
                    cliente_recomendado: { bsonType: 'objectId' }
                }
            }
        }
    });  