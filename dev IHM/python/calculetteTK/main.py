import tkinter as tk
from tkinter import *

class Main(tk.Tk):
    def __init__(self): 
        super().__init__()
        self.title("Calculette")
        self.geometry("250x340")
        self.resizable(False, False)
        self.config(bg="#545c64")

        self.grid_rowconfigure(0, weight=0)
        self.grid_rowconfigure(1, weight=0)
        self.grid_rowconfigure(2, weight=0)
        self.grid_rowconfigure(3, weight=0)
        self.grid_rowconfigure(4, weight=0)
        self.grid_rowconfigure(5, weight=0)
        self.grid_rowconfigure(6, weight=0)
        self.grid_rowconfigure(7, weight=0)

        self.grid_columnconfigure(0, weight=1, uniform="same_group")
        self.grid_columnconfigure(1, weight=1, uniform="same_group")
        self.grid_columnconfigure(2, weight=1, uniform="same_group")
        self.grid_columnconfigure(3, weight=1, uniform="same_group")
        self.grid_columnconfigure(4, weight=1, uniform="same_group")

        default_button_style = {
            "fg": "black", "highlightthickness": 0,
            "font": ("Arial", 13)
        }
        green_button = default_button_style | {"bg": "#b2ca76"}
        red_button = default_button_style | {"bg": "#fb736b"}
        light_blue_button = default_button_style | {"bg": "#d3f3eb"}
        screen = default_button_style | {"bg": "#d3f3eb", "font": ("Arial", 25)}
        default_button_grid = {"padx": 4, "pady": 4, "sticky": "nsew"}

        # Première ligne
        result_label = Label(self, text="0", anchor='se', padx=10, pady=25, **screen)
        result_label.grid(column=0, row=0, columnspan=5, **default_button_grid)

        # Deuxième ligne
        Button(self, text="MC", **green_button).grid(column=0, row=1, **default_button_grid)
        Button(self, text="MR", **green_button).grid(column=1, row=1, **default_button_grid)
        Button(self, text="MS", **green_button).grid(column=2, row=1, **default_button_grid)
        Button(self, text="M+", **green_button).grid(column=3, row=1, **default_button_grid)
        Button(self, text="M-", **green_button).grid(column=4, row=1, **default_button_grid)
        
        # Troisième ligne
        Button(self, text="C",   **red_button).grid(column=0, row=2,  columnspan=2, **default_button_grid)
        Button(self, text="CE",  **red_button).grid(column=2, row=2, columnspan=2, **default_button_grid)
        Button(self, text="<--", **red_button).grid(column=4, row=2, columnspan=2, **default_button_grid)


        # Quatrième ligne      
        Button(self, text="7", **light_blue_button).grid(column=0, row=3, **default_button_grid)
        Button(self, text="8", **light_blue_button).grid(column=1, row=3, **default_button_grid)
        Button(self, text="9", **light_blue_button).grid(column=2, row=3, **default_button_grid)
        Button(self, text="/", **green_button).grid(column=3, row=3, **default_button_grid)
        Button(self, text="±", **green_button).grid(column=4, row=3, **default_button_grid)

        #  Cinquieme ligne      
        Button(self, text="4", **light_blue_button).grid(column=0, row=4, **default_button_grid)
        Button(self, text="5", **light_blue_button).grid(column=1, row=4, **default_button_grid)
        Button(self, text="6", **light_blue_button).grid(column=2, row=4, **default_button_grid)
        Button(self, text="*", **green_button).grid(column=3, row=4, **default_button_grid)
        Button(self, text="%", **green_button).grid(column=4, row=4, **default_button_grid)

        # Sixieme ligne      
        Button(self, text="1", **light_blue_button).grid(column=0, row=5, **default_button_grid)
        Button(self, text="2", **light_blue_button).grid(column=1, row=5, **default_button_grid)
        Button(self, text="3", **light_blue_button).grid(column=2, row=5, **default_button_grid)
        Button(self, text="-", **green_button).grid(column=3, row=5, **default_button_grid)
        Button(self, text="=", **red_button).grid(column=4, row=5,rowspan=2, **default_button_grid)

        # septieme ligne      
        Button(self, text="0", **light_blue_button).grid(column=0, row=6, columnspan=2, **default_button_grid)
        Button(self, text=".", **green_button).grid(column=2, row=6, **default_button_grid)
        Button(self, text="+", **green_button).grid(column=3, row=6, **default_button_grid)



if __name__ == "__main__":
    root = Main()
    root.mainloop()


"""
    background: #545c64;
    light-blue: #d3f3eb;
    green: #b2ca76;
    red: #fb736b;
"""