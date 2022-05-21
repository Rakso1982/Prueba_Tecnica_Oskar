CREATE TABLE Tipo_Documento_Modelo(
id INTEGER NOT NULL,
descripcion VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE Informacion_Cliente_Modelo(
identificacion VARCHAR(10) NOT NULL,
id INTEGER NOT NULL,
correo VARCHAR(255) NOT NULL,
celular VARCHAR(100) NOT NULL,
PRIMARY KEY (identificacion)
);