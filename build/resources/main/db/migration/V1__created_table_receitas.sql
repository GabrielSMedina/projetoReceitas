CREATE TABLE receitas(
    id_receita SERIAL PRIMARY KEY,
    nome_receita VARCHAR(255),
    minutos_preparo INTEGER,
    porcoes INTEGER,
    modo_preparo JSON
);