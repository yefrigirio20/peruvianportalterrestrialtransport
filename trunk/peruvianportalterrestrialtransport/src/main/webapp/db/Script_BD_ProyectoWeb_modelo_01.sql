CREATE DATABASE PERUVIANPORTALTERRESTRIALTRANSPORT;

USE PERUVIANPORTALTERRESTRIALTRANSPORT;

/***************************************/
/************ TABLAS 'SQL' *************/
/***************************************/

CREATE TABLE CLIENTE(
	ID         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NOMBRES    VARCHAR(45)  NULL,
	APELLIDOS  VARCHAR(45)  NULL,
	DIRECCION  VARCHAR(100) NULL,
	DNI        VARCHAR(45)  NULL,
	CUMPLEANOS DATETIME     NULL,
	EMAIL      VARCHAR(45)  NULL,	
	ESTADO     VARCHAR(45)  NULL,
	USUARIO    VARCHAR(45)  NULL,
	PASSWORD   VARCHAR(45)  NULL,
	TIPO       VARCHAR(45)  NULL
);

CREATE TABLE DEPARTAMENTO(
	ID     INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(255) NULL
);

CREATE TABLE EMPRESA(
	ID           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    RAZON_SOCIAL VARCHAR(45)  NULL,
	PAIS         VARCHAR(45)  NULL,
	RUC          VARCHAR(45)  NULL,
	USUARIO      VARCHAR(45)  NULL,
	PASSWORD     VARCHAR(45)  NULL,
    ESTADO       VARCHAR(45)  NULL,	
    DEPARTAMENTO_ID INT REFERENCES DEPARTAMENTO(ID) ON DELETE CASCADE
);

CREATE TABLE AGENCIA(
	ID         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	DIRECCION  VARCHAR(45) NULL,
	EMAIL      VARCHAR(100) NULL,
	ESTADO     VARCHAR(45) NULL,
	NOMBRE     VARCHAR(45) NULL,
	TELEFONO   VARCHAR(45) NULL,
	EMPRESA_ID INT REFERENCES EMPRESA(ID) ON DELETE CASCADE
);

CREATE TABLE VEHICULO (
	ID          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	MODELO      VARCHAR(45) NULL,
	NOMBRE      VARCHAR(45) NULL,
	TIPO        VARCHAR(45) NULL,
	SERVICIO_ID INT REFERENCES SERVICIO(ID) ON DELETE CASCADE
);

CREATE TABLE SERVICIO(
	ID          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOMBRE      VARCHAR(45)  NULL,
	DESCRIPCION VARCHAR(255) NULL,
    MONTO       DOUBLE(9,2)  NULL DEFAULT '0.00',
	AGENCIA_ID  INT REFERENCES AGENCIA(ID)  ON DELETE CASCADE
);

CREATE TABLE ASIENTO(
	ID          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	COLUMNA     VARCHAR(45) NULL,
	FILA        VARCHAR(45) NULL,
	ESTADO      VARCHAR(45) NULL,
	VEHICULO_ID INT REFERENCES VEHICULO(ID) ON DELETE CASCADE
);

CREATE TABLE SALIDA(
	ID                   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	DEPARTAMENTO_SALIDA  VARCHAR(45) NULL,
	DEPARTAMENTO_DESTINO VARCHAR(45) NULL,
	SERVICIO_ID          INT REFERENCES SERVICIO(ID) ON DELETE CASCADE
);

CREATE TABLE CALENDARIO(
	ID                 INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	DURACION           INT      NULL,
	FECHA_HORA_SALIDA  DATETIME NULL,
	FECHA_HORA_LLEGADA DATETIME NULL,
	SALIDA_ID          INT REFERENCES SALIDA(ID) ON DELETE CASCADE
);

CREATE TABLE PAGO(
	ID               INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NUM_TARJETA      VARCHAR(45) NULL,
	TIPO_PAGO        VARCHAR(45) NULL,
	FECHA_EXPIRACION DATE         NULL
);

CREATE TABLE CLIENTE_PAGO(
	ID         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	CLIENTE_ID INT REFERENCES CLIENTE(ID) ON DELETE CASCADE,
    PAGO_ID    INT REFERENCES PAGO(ID)    ON DELETE CASCADE
);

CREATE TABLE TRANSACCION(
	ID              INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	EMPRESA_ID      INT REFERENCES EMPRESA(ID)      ON DELETE NO ACTION,
    CLIENTE_ID      INT REFERENCES CLIENTE(ID)      ON DELETE NO ACTION,
	AGENCIA_ID      INT REFERENCES AGENCIA(ID)      ON DELETE NO ACTION,
    SERVICIO_ID     INT REFERENCES SERVICIO(ID)     ON DELETE NO ACTION,
	SALIDA_ID       INT REFERENCES SALIDA(ID)       ON DELETE NO ACTION,
    VEHICULO_ID     INT REFERENCES VEHICULO(ID)     ON DELETE NO ACTION,
	ASIENTO_ID      INT REFERENCES ASIENTO(ID)      ON DELETE NO ACTION
);
			
CREATE TABLE DETALLE_PASAJE(
	EMPRESA_ID          INT NULL,
	AGENCIA_ID          INT NULL,
	SERVICIO_ID         INT NULL,
	SALIDA_ID           INT NULL,
	CALENDARIO_ID       INT NULL,
	RAZON_SOCIAL        VARCHAR(45) NULL,
	NOM_AGENCIA         VARCHAR(45) NULL,
	NOM_SERVICIO        VARCHAR(45) NULL,
	DEPARTA_SALIDA      VARCHAR(45) NULL,
	DEPARTA_DESTINO     VARCHAR(45) NULL,
	FECHA_HORA_SALIDA   DATETIME    NULL,
	FECHA_HORA_LLEGADA  DATETIME    NULL
);

CREATE TABLE DETALLE_ASIENTO(
	ASIENTO_ID       INT NOT NULL, 
	VEHICULO_ID      INT NULL,
	SERVICIO_ID      INT NULL,
	MOD_VEHICULO     VARCHAR(45) NULL,
	NOM_VEHICULO     VARCHAR(45) NULL,
	ESTADO_VEHICULO  VARCHAR(45) NULL
);
 
/***************************************/
/************ INSERTs 'SQL' ************/
/***************************************/

/**** DEPARTAMENTO ****/
insert into departamento (ID, NOMBRE) values (1, 'LIMA');
insert into departamento (ID, NOMBRE) values (2, 'ICA');
insert into departamento (ID, NOMBRE) values (3, 'CHINCHA');
insert into departamento (ID, NOMBRE) values (4, 'AYACUCHO');
insert into departamento (ID, NOMBRE) values (5, 'CUZCO');
insert into departamento (ID, NOMBRE) values (6, 'LORETO');
insert into departamento (ID, NOMBRE) values (7, 'PIURA');
insert into departamento (ID, NOMBRE) values (8, 'TACNA');
insert into departamento (ID, NOMBRE) values (9, 'HUANUCO');
insert into departamento (ID, NOMBRE) values (10, 'HUANCAYO');
insert into departamento (ID, NOMBRE) values (11, 'CAJAMARCA');
insert into departamento (ID, NOMBRE) values (12, 'SAN MARTIN');
insert into departamento (ID, NOMBRE) values (13, 'PUNO');
insert into departamento (ID, NOMBRE) values (14, 'UCAYALI');
insert into departamento (ID, NOMBRE) values (15, 'CHIMBOTE');

/**** EMPRESA ****/
insert into empresa (ID, RAZON_SOCIAL, PAIS, RUC, USUARIO, PASSWORD, ESTADO, DEPARTAMENTO_ID) values (1, 'CIVA', 'PERU', '22222', 'CIVA', 'CIVA', 'TRUE', 1);
insert into empresa (ID, RAZON_SOCIAL, PAIS, RUC, USUARIO, PASSWORD, ESTADO, DEPARTAMENTO_ID) values (2, 'OLTURSA', 'PERU', '44444', 'OLTURSA', 'OLTURSA', 'TRUE', 1);
insert into empresa (ID, RAZON_SOCIAL, PAIS, RUC, USUARIO, PASSWORD, ESTADO, DEPARTAMENTO_ID) values (3, 'CRUZ DEL SUR', 'PERU', '55555', 'CRUZDELSUR', 'CRUZDELSUR', 'TRUE', 1);

/**** AGENCIA ****/
insert into agencia (ID, DIRECCION, EMAIL, ESTADO, NOMBRE, TELEFONO, EMPRESA_ID) values (1, 'AV.XXXX', 'TRANSPORTECIVA@CIVA.COM', 'TRUE', 'AGENCIA SAN LIMA', '4574512', 1);
insert into agencia (ID, DIRECCION, EMAIL, ESTADO, NOMBRE, TELEFONO, EMPRESA_ID) values (2, 'AV.XXXX', 'TRANSPORTEOLTURSA@OLTURSA.COM', 'TRUE', 'AGENCIA SAN BORJA', '4555512', 2);
insert into agencia (ID, DIRECCION, EMAIL, ESTADO, NOMBRE, TELEFONO, EMPRESA_ID) values (3, 'AV.XXXX', 'TRANSPORTECRUZDELSUR@CRUZDELSUR.COM', 'TRUE', 'AGENCIA SAN ISIDRO', '4774512', 2);

/**** SERVICIO ****/
insert into servicio (ID, NOMBRE, DESCRIPCION, MONTO, AGENCIA_ID) values (1, 'IMPERIAL', 'AAAA', 40.0, 2);
insert into servicio (ID, NOMBRE, DESCRIPCION, MONTO, AGENCIA_ID) values (2, 'EJECUTIVO', 'BBB', 40.0, 2);

/**** VEHICULO ****/
insert into vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) values (1, 'MQT242', 'VOLVO', '1 PISO', 2);
insert into vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) values (2, 'RTR979', 'VOLVO', '2 PISOS', 2);

/**** ASIENTO ****/
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (1, 'A', '1', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (2, 'A', '2', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (3, 'A', '3', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (4, 'A', '4', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (5, 'A', '5', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (6, 'A', '6', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (7, 'A', '7', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (8, 'A', '8', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (9, 'A', '9', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (10, 'B', '10', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (11, 'B', '1', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (12, 'B', '2', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (13, 'B', '3', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (14, 'B', '4', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (15, 'B', '5', 'TRUE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (16, 'B', '6', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (17, 'B', '7', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (18, 'B', '8', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (19, 'B', '9', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (20, 'C', '10', 'TRUE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (21, 'C', '1', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (22, 'C', '2', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (23, 'C', '3', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (24, 'C', '4', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (25, 'C', '5', 'TRUE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (26, 'C', '6', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (27, 'C', '7', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (28, 'C', '8', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (29, 'C', '9', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (30, 'D', '10', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (31, 'D', '2', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (32, 'D', '3', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (33, 'D', '3', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (34, 'D', '4', 'TRUE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (35, 'D', '5', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (36, 'D', '6', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (37, 'D', '7', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (38, 'D', '8', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (39, 'D', '9', 'FALSE', 1);
insert into asiento (ID, COLUMNA, FILA, ESTADO, VEHICULO_ID) values (40, 'D', '10', 'FALSE', 1);

/**** SALIDA ****/
insert into salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) values (1, 'LIMA', 'ICA', 2);
insert into salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) values (2, 'LIMA', 'CUZCO', 2);
insert into salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) values (3, 'LIMA', 'PIURA', 2);
insert into salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) values (4, 'LIMA', 'CAJAMARCA', 2);

/**** CALENDARIO ****/
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (1, 4, '2010-07-10 12:00:00', '2010-07-10 18:00:00', 1);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (2, 4, '2010-07-10 14:00:00', '2010-07-10 17:00:00', 1);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (3, 18, '2010-08-10 02:00:00', '2010-07-10 08:00:00', 2);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (4, 18, '2010-08-10 03:00:00', '2010-07-10 09:00:00', 2);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (5, 18, '2010-08-10 04:00:00', '2010-08-10 10:00:00', 2);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (6, 14, '2010-07-10 02:00:00', '2010-07-10 08:00:00', 3);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (7, 14, '2010-07-10 09:00:00', '2010-07-10 23:00:00', 3);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (8, 12, '2010-07-10 08:00:00', '2010-07-10 20:00:00', 4);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (9, 12, '2010-07-10 09:00:00', '2010-07-10 20:00:00', 4);
insert into calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) values (10, 12, '2010-07-10 10:00:00', '2010-07-10 18:00:00', 4);

/**** CLIENTE ****/
insert into cliente (ID, NOMBRES, APELLIDOS, DIRECCION, DNI, CUMPLEANOS, EMAIL, ESTADO, USUARIO, PASSWORD, TIPO) values (1, 'CESAR RICARDO', 'GUERRA ARNAIZ', 'AV.NARANJAL 1029 LOS OLIVOS', '41816133', '2010-07-11 00:00:00', 'CGUERRAA@HP.COM', 'TRUE', 'RGUERRA', 'ADMIN', 'ADMINISTRADOR');

/**** PAGO ****/
insert into pago (ID, NUM_TARJETA, TIPO_PAGO, FECHA_EXPIRACION) values (1, '4578548778', 'ADMINISTRADOR', '2010-12-11');

/**** VEHICULO ****/
insert into vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) values (1, 'MQT242', 'VOLVO', '1 PISO',  2);
insert into vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) values (2, 'RTR979', 'VOLVO', '2 PISOS', 2);

/**** CLIENTE_PAGO ****/
insert into cliente_pago (ID, CLIENTE_ID, PAGO_ID) values (1, 1, 1);

/**** TRANSACCION ****/
insert into transaccion (ID, EMPRESA_ID, CLIENTE_ID, AGENCIA_ID, SERVICIO_ID, SALIDA_ID, VEHICULO_ID, ASIENTO_ID) values (1, 1, 1, 1, 1, 1, 1, 1);


/***************************************/
/*********** CONSULTAS 'SQL' ***********/
/***************************************/

/**** FORMA #1 ****/

SELECT e.RAZON_SOCIAL, e.PAIS, a.NOMBRE, s.NOMBRE,
       sa.DEPARTAMENTO_SALIDA, sa.DEPARTAMENTO_DESTINO,
       c.FECHA_HORA_SALIDA, c.FECHA_HORA_LLEGADA
FROM   EMPRESA e, AGENCIA a, SERVICIO s,
       SALIDA sa, CALENDARIO c
WHERE  e.ID  = a.ID  AND
       a.ID  = s.ID  AND
       s.ID  = sa.ID AND
       sa.ID = c.ID;


/**** FORMA #2 ****/

SELECT e.RAZON_SOCIAL, e.PAIS, a.NOMBRE, s.NOMBRE,
       sa.DEPARTAMENTO_SALIDA, sa.DEPARTAMENTO_DESTINO,
       c.FECHA_HORA_SALIDA, c.FECHA_HORA_LLEGADA
FROM   EMPRESA    e  INNER  JOIN
       AGENCIA    a  INNER  JOIN
       SERVICIO   s  INNER  JOIN
       SALIDA     sa INNER  JOIN
       CALENDARIO c
ON     e.ID  = a.ID  AND
       a.ID  = s.ID  AND
       s.ID  = sa.ID AND
       sa.ID = c.ID;