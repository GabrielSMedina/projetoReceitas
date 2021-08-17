CREATE TABLE receitas(
    id_receita INTEGER PRIMARY KEY,
    nome_receita VARCHAR(255),
    minutos_preparo INTEGER,
    porcoes INTEGER
);

CREATE TABLE ingredientes(
    id_ingrediente INTEGER PRIMARY KEY,
    nome_ingrediente VARCHAR(255) UNIQUE
);

CREATE TABLE etapas(
    id_etapa INTEGER PRIMARY KEY,
    id_receita INTEGER,
    numero_etapa INTEGER,
    descricao TEXT,

    FOREIGN KEY(id_receita)
        REFERENCES receitas(id_receita)
);

CREATE TABLE unidades(
    id_unidade INTEGER PRIMARY KEY,
    unidade VARCHAR(55) UNIQUE
);

CREATE TABLE receitas_ingredientes(
    id_receita_ingrediente INTEGER PRIMARY KEY,
    id_receita INTEGER,
    id_ingrediente INTEGER,
    id_unidade INTEGER,
    quantidade_ingrediente REAL,

    FOREIGN KEY(id_receita)
        REFERENCES receitas(id_receita),
    FOREIGN KEY(id_ingrediente)
        REFERENCES ingredientes(id_ingrediente),
    FOREIGN KEY(id_unidade)
        REFERENCES unidades(id_unidade)
);