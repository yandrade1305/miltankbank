CREATE SCHEMA MILTANKBANK;

CREATE SEQUENCE MILTANKBANK.ID_RECEITA_SEQ;

CREATE TABLE MILTANKBANK.RECEITA (
    ID_RECEITA INTEGER NOT NULL DEFAULT NEXTVAL ('MILTANKBANK.ID_RECEITA_SEQ'),
    DESCRICAO_RECEITA CHARACTER VARYING(100) NOT NULL,
    VALOR_RECEITA NUMERIC(10,2) NOT NULL,
    DATA_RECEITA DATE NOT NULL,
    PRIMARY KEY (ID_RECEITA)    
);

CREATE SEQUENCE MILTANKBANK.ID_DESPESA_SEQ;

CREATE TABLE MILTANKBANK.DESPESA (
    ID_DESPESA INTEGER NOT NULL DEFAULT NEXTVAL ('MILTANKBANK.ID_DESPESA_SEQ'),
    DESCRICAO_DESPESA CHARACTER VARYING(100) NOT NULL,
    VALOR_DESPESA NUMERIC(10,2) NOT NULL,
    DATA_DESPESA DATE NOT NULL,
    PRIMARY KEY (ID_DESPESA)
);

DELETE FROM MILTANKBANK.DESPESA;

DELETE FROM MILTANKBANK.RECEITA;
