export class Alunos {

    constructor(

        public identificacao: Number | null,
        public nome: String,
        public sexo: String,
        public data_nascimento: Date,
        public idade: Number,
        public nota_1: Number,
        public nota_2: Number,
        public nota_3: Number,
        public media: Number | null

    ) { }
}