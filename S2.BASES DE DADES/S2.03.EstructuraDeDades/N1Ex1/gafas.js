
db.createCollection('gafas',
    {
        validator:
        {
            $jsonSchema:
            {
                bsonType: 'object', title: 'gafas',
                required: ['marca', 'graduacion_ojo_izq', 'graduacion_ojo_der', 'tipo_montura', 'color_montura', 'color_cristales', 'precio', 'proveedor', 'cliente', 'empleado_venta'],
                properties: {
                    marca: { bsonType: 'string' },
                    graduacion_ojo_izq: { bsonType: 'int' },
                    graduacion_ojo_der: { bsonType: 'int' },
                    tipo_montura: { enum: ['flotante', 'pasta', 'metalica'] },
                    color_montura: { bsonType: 'string' },
                    color_cristales: { bsonType: 'string' },
                    precio: { bsonType: 'double' },
                    proveedor: { bsonType: 'objectId' },
                    cliente: { bsonType: 'objectId' },
                    empleado_venta: {
                        bsonType: 'object',
                        title: 'empleado',
                        required: ['nombre', 'apellido'],
                        properties: {
                            nombre: { bsonType: 'string' },
                            apellido: { bsonType: 'string' }
                        }
                    }
                }
            }
        },
        autoIndexId: true
    });  