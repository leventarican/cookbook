import pyxel

# init modules
pyxel.init(160, 120)

def update():
    if pyxel.btnp(pyxel.KEY_Q):
        pyxel.quit()

def draw():
    pyxel.cls(0)
    # x, y, w, h, color: 0-15
    pyxel.rect(10, 10, 20, 20, 1)

# call update and draw function
pyxel.run(update, draw)