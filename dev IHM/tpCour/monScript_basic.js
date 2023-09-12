class Model {

    #number
    constructor(number) {
        this.#number = number;
    }

    get number() {
        return this.#number;
    }


    increment() {
        this.#number++;

        return this.#number;
    }
}


class View {
    #display;
    #button;

    constructor(display, buttonPlus) {
        this.#display = display;
        this.#button = buttonPlus;
    }

    getButton() {
        return this.#button;
    }

    updateView(n) {
        this.#display.innerHTML = n;
    }

    changeButtonColor () {
        
    }

}

class Controller {
    #model;
    #view;

    constructor(model, view) {
        this.#model = model;
        this.#view = view;
        this.#view.getButton().addEventListener('click', this.callBack);
    }

    callBack = () => {
        let n = this.#model.increment()
        this.#view.updateView(n);
    }
}

const display = document.querySelector('#displayedNumber');
const button = document.querySelector('#buttonAdd');

const model = new  Model(0);
const view = new View(display, button);
const app = new Controller(model, view);