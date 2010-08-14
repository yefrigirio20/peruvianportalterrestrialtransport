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
	COLUMNA_A   VARCHAR(10) NULL,
	COLUMNA_B   VARCHAR(10) NULL,
	COLUMNA_C   VARCHAR(10) NULL,
	COLUMNA_D   VARCHAR(10) NULL,
    ESTADO_CA   VARCHAR(10) NULL,
    ESTADO_CB   VARCHAR(10) NULL,
    ESTADO_CC   VARCHAR(10) NULL,
    ESTADO_CD   VARCHAR(10) NULL,
	ESTADO      VARCHAR(10) NULL,
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
	ASIENTO_ID         INT NOT NULL, 
	VEHICULO_ID        INT NULL,
	SERVICIO_ID        INT NULL,
	MOD_VEHICULO       VARCHAR(45) NULL,
	NOM_VEHICULO       VARCHAR(45) NULL,	
    FILA_ASIENTO       VARCHAR(10) NULL,
	COLUMNA_ASIENTO_A  VARCHAR(10) NULL,	
	COLUMNA_ASIENTO_B  VARCHAR(10) NULL,	
	COLUMNA_ASIENTO_C  VARCHAR(10) NULL,	
	COLUMNA_ASIENTO_D  VARCHAR(10) NULL,
    ESTADO_CA          VARCHAR(10) NULL,
    ESTADO_CB          VARCHAR(10) NULL,
    ESTADO_CC          VARCHAR(10) NULL,
    ESTADO_CD          VARCHAR(10) NULL,		
	ESTADO_VEHICULO    VARCHAR(10) NULL
);
 
/***************************************/
/************ INSERTs 'SQL' ************/
/***************************************/

/**** DEPARTAMENTO ****/
INSERT INTO departamento (ID, NOMBRE) VALUES (1, 'LIMA');
INSERT INTO departamento (ID, NOMBRE) VALUES (2, 'ICA');
INSERT INTO departamento (ID, NOMBRE) VALUES (3, 'CHINCHA');
INSERT INTO departamento (ID, NOMBRE) VALUES (4, 'AYACUCHO');
INSERT INTO departamento (ID, NOMBRE) VALUES (5, 'CUZCO');
INSERT INTO departamento (ID, NOMBRE) VALUES (6, 'LORETO');
INSERT INTO departamento (ID, NOMBRE) VALUES (7, 'PIURA');
INSERT INTO departamento (ID, NOMBRE) VALUES (8, 'TACNA');
INSERT INTO departamento (ID, NOMBRE) VALUES (9, 'HUANUCO');
INSERT INTO departamento (ID, NOMBRE) VALUES (10, 'HUANCAYO');
INSERT INTO departamento (ID, NOMBRE) VALUES (11, 'CAJAMARCA');
INSERT INTO departamento (ID, NOMBRE) VALUES (12, 'SAN MARTIN');
INSERT INTO departamento (ID, NOMBRE) VALUES (13, 'PUNO');
INSERT INTO departamento (ID, NOMBRE) VALUES (14, 'UCAYALI');
INSERT INTO departamento (ID, NOMBRE) VALUES (15, 'CHIMBOTE');

/**** EMPRESA ****/
INSERT INTO empresa (ID, RAZON_SOCIAL, PAIS, RUC, USUARIO, PASSWORD, ESTADO, DEPARTAMENTO_ID) VALUES (1, 'CIVA', 'PERU', '22222', 'CIVA', 'CIVA', 'TRUE', 1);
INSERT INTO empresa (ID, RAZON_SOCIAL, PAIS, RUC, USUARIO, PASSWORD, ESTADO, DEPARTAMENTO_ID) VALUES (2, 'OLTURSA', 'PERU', '44444', 'OLTURSA', 'OLTURSA', 'TRUE', 1);
INSERT INTO empresa (ID, RAZON_SOCIAL, PAIS, RUC, USUARIO, PASSWORD, ESTADO, DEPARTAMENTO_ID) VALUES (3, 'CRUZ DEL SUR', 'PERU', '55555', 'CRUZDELSUR', 'CRUZDELSUR', 'TRUE', 1);

/**** AGENCIA ****/
INSERT INTO agencia (ID, DIRECCION, EMAIL, ESTADO, NOMBRE, TELEFONO, EMPRESA_ID) VALUES (1, 'AV.XXXX', 'TRANSPORTECIVA@CIVA.COM', 'TRUE', 'AGENCIA SAN LIMA', '4574512', 1);
INSERT INTO agencia (ID, DIRECCION, EMAIL, ESTADO, NOMBRE, TELEFONO, EMPRESA_ID) VALUES (2, 'AV.XXXX', 'TRANSPORTEOLTURSA@OLTURSA.COM', 'TRUE', 'AGENCIA SAN BORJA', '4555512', 2);
INSERT INTO agencia (ID, DIRECCION, EMAIL, ESTADO, NOMBRE, TELEFONO, EMPRESA_ID) VALUES (3, 'AV.XXXX', 'TRANSPORTECRUZDELSUR@CRUZDELSUR.COM', 'TRUE', 'AGENCIA SAN ISIDRO', '4774512', 2);

/**** SERVICIO ****/
INSERT INTO servicio (ID, NOMBRE, DESCRIPCION, MONTO, AGENCIA_ID) VALUES (1, 'IMPERIAL', 'AAAA', 40.0, 2);
INSERT INTO servicio (ID, NOMBRE, DESCRIPCION, MONTO, AGENCIA_ID) VALUES (2, 'EJECUTIVO', 'BBB', 40.0, 2);

/**** VEHICULO ****/
INSERT INTO vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) VALUES (1, 'MQT242', 'VOLVO', '1 PISO', 2);
INSERT INTO vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) VALUES (2, 'RTR979', 'VOLVO', '2 PISOS', 2);

/**** ASIENTO ****/
INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 1, '1', '2', '3', '4', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 2, '5', '6', '7', '8', 'FALSE', 'TRUE', 'FALSE', 'FALSE', 'FALSE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 3, '9', '10', '11', '12', 'FALSE', 'FALSE', 'TRUE', 'FALSE', 'TRUE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 4, '13', '14', '15', '16', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 5, '17', '18', '19', '20', 'FALSE', 'TRUE', 'FALSE', 'FALSE', 'FALSE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 6, '21', '22', '23', '24', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 7, '25', '26', '27', '28', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 'TRUE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 8, '29', '30', '31', '32', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 9, '33', '34', '35', '36', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 'FALSE', 1 );

INSERT INTO ASIENTO( ID, COLUMNA_A, COLUMNA_B, COLUMNA_C, COLUMNA_D, ESTADO_CA,  ESTADO_CB, ESTADO_CC, ESTADO_CD, ESTADO, VEHICULO_ID ) 
VALUES( 10, '37', '38', '39', '40', 'FALSE', 'FALSE', 'FALSE', 'TRUE', 'FALSE', 1 );

/**** SALIDA ****/
INSERT INTO salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) VALUES (1, 'LIMA', 'ICA', 2);
INSERT INTO salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) VALUES (2, 'LIMA', 'CUZCO', 2);
INSERT INTO salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) VALUES (3, 'LIMA', 'PIURA', 2);
INSERT INTO salida (ID, DEPARTAMENTO_SALIDA, DEPARTAMENTO_DESTINO, SERVICIO_ID) VALUES (4, 'LIMA', 'CAJAMARCA', 2);

/**** CALENDARIO ****/
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (1, 4,  '2010-08-20 12:00:00', '2010-08-20 18:00:00', 1);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (2, 4,  '2010-08-20 14:00:00', '2010-08-20 17:00:00', 1);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (3, 18, '2010-09-20 02:00:00', '2010-08-20 08:00:00', 2);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (4, 18, '2010-09-20 03:00:00', '2010-08-20 09:00:00', 2);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (5, 18, '2010-09-20 04:00:00', '2010-09-20 10:00:00', 2);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (6, 14, '2010-08-20 02:00:00', '2010-08-20 08:00:00', 3);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (7, 14, '2010-08-20 09:00:00', '2010-08-20 23:00:00', 3);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (8, 12, '2010-08-20 08:00:00', '2010-08-20 20:00:00', 4);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (9, 12, '2010-08-20 09:00:00', '2010-08-20 20:00:00', 4);
INSERT INTO calendario (ID, DURACION, FECHA_HORA_SALIDA, FECHA_HORA_LLEGADA, SALIDA_ID) VALUES (10,12, '2010-08-20 10:00:00', '2010-08-20 18:00:00', 4);

/**** CLIENTE ****/
INSERT INTO cliente (ID, NOMBRES, APELLIDOS, DIRECCION, DNI, CUMPLEANOS, EMAIL, ESTADO, USUARIO, PASSWORD, TIPO) VALUES (1, 'CESAR RICARDO', 'GUERRA ARNAIZ', 'AV.NARANJAL 1029 LOS OLIVOS', '41816133', '2010-07-11 00:00:00', 'CGUERRAA@HP.COM', 'TRUE', 'RGUERRA', 'SqrAquYuou8=', 'ADMINISTRADOR');

/**** PAGO ****/
INSERT INTO pago (ID, NUM_TARJETA, TIPO_PAGO, FECHA_EXPIRACION) VALUES (1, '4578548778', 'ADMINISTRADOR', '2010-12-11');

/**** VEHICULO ****/
INSERT INTO vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) VALUES (1, 'MQT242', 'VOLVO', '1 PISO',  2);
INSERT INTO vehiculo (ID, MODELO, NOMBRE, TIPO, SERVICIO_ID) VALUES (2, 'RTR979', 'VOLVO', '2 PISOS', 2);

/**** CLIENTE_PAGO ****/
INSERT INTO cliente_pago (ID, CLIENTE_ID, PAGO_ID) VALUES (1, 1, 1);

/**** TRANSACCION ****/
INSERT INTO transaccion (ID, EMPRESA_ID, CLIENTE_ID, AGENCIA_ID, SERVICIO_ID, SALIDA_ID, VEHICULO_ID, ASIENTO_ID) VALUES (1, 1, 1, 1, 1, 1, 1, 1);


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