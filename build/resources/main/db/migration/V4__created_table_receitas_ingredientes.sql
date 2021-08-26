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