class Model {
    #content;
    #memory;
    #increment;
    #operation;


    constructor(content) {
        console.log("init du modele");
        this.#content = content;
        console.log("le modele est initialisé");
    }

    getContent() {
        return this.#content;
    }

    modifyContent(caller) {
        console.log("modification du modèle");
        if (caller.id === "C") {
            this.#content = 0;
        } else if (caller.id === "back") {
            this.eraseButton();
        } else if (caller.id === "CE") {
            this.#content = 0;
        } else if (caller.id === "plusMinus"){
            this.changeSign();
        } else if (caller.id === "dot") {
            this.dotButton();
        } else {
            this.write(caller.innerText)
        }
    }

    operation(operation) {
        console.log("ajout de l'opération" + operation);
        this.#operation = operation;

        return this.#operation;
    }

    dotButton() {
        // on vérifie que le nombre n'a pas déjà un point
        if (!this.getContent().toString().includes(".")) {
            // si le nombre est 0, on le remplace par 0.
            if (this.getContent() === 0) {
                this.#content = "0.";
            } else {
                this.write(".");
            }
        }

        return this.#content;
    }

    eraseButton() {
        // on vérifie que le nombre n'est pas OVERFLOW
        if (this.getContent() !== "OVERFLOW") {
            // si le nombre est 0, on ne fait rien
            if (this.getContent().toString().length === 1) this.#content = 0;
            else {
                // on enlève le dernier caractère
                this.#content = this.getContent().toString().slice(0, -1);
            }
        } else {
            this.#content = 0;
        }

        return this.#content;
    }

    write(value) {
        // si la longueur du nombre est supérieure à 14, on affiche OVERFLOW
        if (this.getContent().length > 14) {
            this.#content = "OVERFLOW";
            return;
        }
        // si le nombre est OVERFLOW, on ne fait rien
        if (this.getContent() === "OVERFLOW") return;

        // si le nombre est 0, on le remplace par la valeur
        if (this.getContent() === 0) this.#content = "";


        this.#content += value;
        return this.#content;
    }

    changeSign() {
        // on vérifie que le nombre n'est pas OVERFLOW
        if (this.getContent() !== "OVERFLOW") {
            this.#content = -this.#content;
        }
    }
}

class View {
    #display;
    #buttons

    constructor() {
        console.log("init de la vue");
        this.#display = document.getElementById("screen");
        this.#buttons = {
            memory: {
                MR: document.getElementById("MR"),
                MS: document.getElementById("MS"),
                MC: document.getElementById("MC"),
                Mplus: document.getElementById("Mplus"),
                Mminus: document.getElementById("Mminus")
            },
            clearing: {
                C: document.getElementById("C"),
                CE: document.getElementById("CE"),
                back: document.getElementById("back")
            },
            operations: {
                slash: document.getElementById("slash"),
                plusMinus: document.getElementById("plusMinus"),
                multiply: document.getElementById("multiply"),
                percentage: document.getElementById("percentage"),
                minus: document.getElementById("minus"),
                plus: document.getElementById("plus")
            },
            numbers: document.getElementsByClassName("number"),
            exe: document.getElementById("EXE"),
            dot: document.getElementById("dot")
        };
        console.log("la vue est initialisée");
    
    }


    updateView(n) {
        this.#display.innerText = n;
    }

    bindMyButton(arg) {
        console.log("bind des boutons")
        for (let key in this.#buttons.memory) {
            this.#buttons.memory[key].addEventListener("click", arg);
        }
        for (let i = 0; i < this.#buttons.numbers.length; i++) {
            this.#buttons.numbers[i].addEventListener("click", arg);
        }
        for (let key in this.#buttons.clearing) {
            this.#buttons.clearing[key].addEventListener("click", arg);
        }
        for (let key in this.#buttons.operations) {
            this.#buttons.operations[key].addEventListener("click", arg);
        }
        this.#buttons.exe.addEventListener("click", arg);
        this.#buttons.dot.addEventListener("click", arg);

    }
}

class Controller {
    model;
    view;

    constructor(argModel, argView) {
        console.log("init du controller");
        this.model = argModel;
        this.view = argView;
        this.view.bindMyButton(this.callBack)
        console.log("Le controller est initialisé");
    }

    updateModel(appellant) {
        console.log("mise à jour du modèle appelant : " + appellant.id);
        this.model.modifyContent(appellant);
    }

    updateView() {
        console.log("mise à jour de la vue");
        this.view.updateView(this.model.getContent());
    }

    callBack = (event) => {
        console.log("callback");
        const button = event.target;
        this.updateModel(button);
        this.updateView();
    }
}

console.log("lancement de l'app");
const app = new Controller(new Model(0), new View());
console.log("L'app est lancée");

app.updateView();

