
db.createCollection('proveedor',
    {
        validator:
        {
            $jsonSchema:
            {
                bsonType: 'object', title: 'proveedor',
                required: ['nombre', 'telefono', 'direccion','NIF', 'marcas'],
                properties: {
                    nombre: { bsonType: 'string' },
                    direccion: {
                        bsonType: 'object',
                        title: 'direccion',
                        required: ['calle', 'numero', 'piso', 'puerta', 'ciudad', 'codigo_postal', 'pais'],
                        properties: {
                            calle: { bsonType: 'string' },
                            numero: { bsonType: 'int' },
                            piso: { bsonType: 'string' },
                            puerta: { bsonType: 'int' },
                            ciudad: { bsonType: 'string' },
                            codigo_postal: { bsonType: 'int' },
                            pais: { bsonType: 'string' }
                        }
                    }, 
                    telefono: { bsonType: 'int' },
                    fax: { bsonType: 'int' },
                    NIF: { bsonType: 'int' },
                    marcas: {
                        bsonType: 'array',
                        items: { bsonType: 'string' }
                    }
                }
            }
        }
    });  