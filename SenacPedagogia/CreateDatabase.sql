CREATE TABLE curso (id INTEGER PRIMARY KEY, nomeCurso VARCHAR(255) );
CREATE TABLE alunos (id_aluno INTEGER PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(255),fone VARCHAR(20),cpf VARCHAR(14),email VARCHAR(255),data_nasc DATE,endereco VARCHAR(255),create_dat DATE,loaded_at DATE);
CREATE TABLE professores (id_professor INTEGER PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(255), email VARCHAR(255),cpf VARCHAR(14),data_nasc DATE,endereco VARCHAR(255),fone VARCHAR(20),create_dat DATE,loaded_at DATE);
CREATE TABLE turma (id INTEGER PRIMARY KEY,id_professor INTEGER,id_curso INTEGER,data_inicio DATE,data_final DATE,carga_horaria INTEGER,FOREIGN KEY (id_professor) REFERENCES professores(id_professor),FOREIGN KEY (id_curso) REFERENCES curso(id));
CREATE TABLE cronograma (id INTEGER PRIMARY KEY AUTO_INCREMENT,id_turma INTEGER,nome_curso VARCHAR(255),nome_professor VARCHAR(255),data DATE,FOREIGN KEY (id_turma) REFERENCES turma(id));
CREATE TABLE AccountLogin (idLogin SERIAL PRIMARY KEY,idProfessor INTEGER,login VARCHAR(255),senha VARCHAR(255));
