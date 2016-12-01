CREATE TABLE tb_uf(
id INTEGER PRIMARY KEY,
sigla CHAR(2) NOT NULL
);

CREATE TABLE tb_municipio(
id INTEGER PRIMARY KEY,
municipio character varying(35) NOT NULL,
id_uf INTEGER NOT NULL REFERENCES tb_uf(id)
);
