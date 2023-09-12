class Model {

    constructor() {
    }

}

class View {
    #display;
    #button;

    constructor (display, buttonPlus) {
        this.#display = display;
        this.#button = buttonPlus;
    }

    getButton() {
        return this.#button;
    }

}

class Controller {

    #view;
    #model;

    cosntructor(view, model) {
        this.#view = view;
        this.#model = model;
        this.#view.getButton().addEventListener('click', this.updateModel.bind(this));
    }

    updateModel() {
        let result = this.#model.increment()
        this.updateView(result)
    }

}

const display = document.querySelector('#displayedNumber');
const buttonPlus = document.querySelector('#buttonPlus');

const model = new Model();
const view = new View(display, buttonPlus);
const controller = new Controller(view, model);