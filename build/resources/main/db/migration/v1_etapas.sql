CREATE TABLE etapas(
    id_etapa INTEGER PRIMARY KEY,
    id_receita INTEGER,
    numero_etapa INTEGER,
    descricao TEXT,

    FOREIGN KEY(id_receita)
        REFERENCES receitas(id_receita)
);
