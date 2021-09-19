CREATE TABLE receitas_ingredientes(
    id SERIAL PRIMARY KEY,
    id_receita INTEGER,
    id_ingrediente INTEGER,
    id_unidade INTEGER,
    quantidade_ingrediente REAL,

    FOREIGN KEY(id_receita)
        REFERENCES receitas(id),
    FOREIGN KEY(id_ingrediente)
        REFERENCES ingredientes(id),
    FOREIGN KEY(id_unidade)
        REFERENCES unidades(id)
);