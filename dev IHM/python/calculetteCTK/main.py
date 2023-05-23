import tkinter as tk
import customtkinter as ctk

class Calculette(ctk.CTk):

    def __init__(self):
        super().__init__()
        self.title("Calculette")
        self.geometry("220x300")
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


        text_var = tk.StringVar(value="")
        label = ctk.CTkLabel(master=self,
                               textvariable=text_var,
                               width=210,
                               height=75,
                               bg_color="#d3f3eb",
                               text_color="black",
                               font=("Arial", 25),
                               corner_radius=8)
        label.grid(column=0, row=0,pady=5, columnspan=5)

        self.button = ctk.CTkButton(master=self, text="MC",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=0, row=1, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="MR",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=1, row=1, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="MS",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=2, row=1, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="M+",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=3, row=1, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="M-",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=4, row=1, padx=2, pady=3, sticky="nsew")
        

        self.button = ctk.CTkButton(master=self, text="C",bg_color="#545c64",fg_color="#fb736b",text_color="black", corner_radius=9)
        self.button.grid(column=0, row=2, padx=2, pady=3, columnspan=2, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="CE",bg_color="#545c64",fg_color="#fb736b",text_color="black", corner_radius=9)
        self.button.grid(column=2, row=2, padx=2, pady=3, columnspan=2, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="<--",bg_color="#545c64",fg_color="#fb736b",text_color="black", corner_radius=9)
        self.button.grid(column=4, row=2, padx=2, pady=3, columnspan=3, sticky="nsew")


        self.button = ctk.CTkButton(master=self, text="7",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=0, row=3, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="8",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=1, row=3, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="9",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=2, row=3, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="/",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=3, row=3, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="±",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=4, row=3, padx=2, pady=3, sticky="nsew")


        self.button = ctk.CTkButton(master=self, text="4",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=0, row=4, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="5",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=1, row=4, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="6",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=2, row=4, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="*",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=3, row=4, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="%",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=4, row=4, padx=2, pady=3, sticky="nsew")


        self.button = ctk.CTkButton(master=self, text="1",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=0, row=5, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="2",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=1, row=5, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="3",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=2, row=5, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="-",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=3, row=5, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="=",bg_color="#545c64",fg_color="#fb736b",text_color="black", corner_radius=9)
        self.button.grid(column=4, row=5, padx=2, pady=3,rowspan=2, sticky="nsew")


        self.button = ctk.CTkButton(master=self, text="0",bg_color="#545c64",fg_color="#d3f3eb",text_color="black", corner_radius=9)
        self.button.grid(column=0, row=6, padx=2, pady=3, columnspan=2, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text=".",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=2, row=6, padx=2, pady=3, sticky="nsew")
        self.button = ctk.CTkButton(master=self, text="+",bg_color="#545c64",fg_color="#b2ca76",text_color="black", corner_radius=9)
        self.button.grid(column=3, row=6, padx=2, pady=3, sticky="nsew")







        


if __name__ == "__main__":
    app = Calculette()
    app.mainloop()


# Path: calculetteCTK\customtkinter.py
