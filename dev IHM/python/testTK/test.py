import tkinter as tk

root = tk.Tk()
root.title("Test")
root.geometry("300x300")
root.maxsize(300, 300)
root.minsize(300, 300)


def test():
    print("test")

button = tk.Button(root, text="Test", command=test)
button.pack()

root.mainloop()
