CREATE TABLE receitas(
    id SERIAL PRIMARY KEY,
    nome_receita VARCHAR(255),
    minutos_preparo INTEGER,
    porcoes INTEGER,
    modo_preparo TEXT
);