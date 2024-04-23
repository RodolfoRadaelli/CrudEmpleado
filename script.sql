SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Departamentos;
DROP TABLE IF EXISTS Trabajadores;
SET foreign_key_checks = 1;

CREATE TABLE Departamentos ( 
    id BIGINT NOT NULL AUTO_INCREMENT,
    departamentoNombre VARCHAR(50) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE Trabajadores ( 
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    salario DECIMAL(5, 2) NOT NULL,
    departamentoId BIGINT NOT NULL, 
    

    PRIMARY KEY (id),
    CONSTRAINT fk_Trabajadores_Departamentos FOREIGN KEY (departamentoId) REFERENCES Departamentos(id)
);

INSERT INTO Departamentos
    (departamentoNombre)
    Values
        ("Soporte Tecnico"),
        ("Ventas"),
        ("Marketing"),
        ("Atención al cliente"),
        ("CEO");

INSERT INTO Trabajadores
    (nombre, apellido, salario, departamentoId)
    Values
        ("Roberto", "Bolaño", 300.5, 2),
        ("Carla", "Casares", 450, 1),
        ("Cristian", "Maldonado", 450, 1),
        ("Matias", "Lizarraga", 220, 4),
        ("Adolfo", "Mendez", 300, 3),
        ("Pablo", "Vera", 600, 5);
