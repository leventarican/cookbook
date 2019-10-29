import pyxel

# max width and height of screen is 256
# pyxel.init(256, 256, caption='load resource example', scale=1)
pyxel.init(64, 32, caption='load resource example', scale=10)

pyxel.load("assets/resource0.pyxres")
IMAGE_BANK = 0  # (0-2)
VELOCITY = 5

player_x = 0
player_y = 0

def update():
    global player_x
    global player_y

    if pyxel.btnp(pyxel.KEY_Q):
        pyxel.quit()
    if pyxel.btn(pyxel.KEY_LEFT):
        player_x -= VELOCITY
    if pyxel.btn(pyxel.KEY_RIGHT):
        player_x += VELOCITY
    if pyxel.btn(pyxel.KEY_UP):
        player_y -= VELOCITY
    if pyxel.btn(pyxel.KEY_DOWN):
        player_y += VELOCITY

def draw():
    global player_x
    global player_y

    pyxel.cls(0)

    # blt(x, y, img, u, v, w, h, [colkey])

    # 256x256 sized 3 image banks

    # Copy the region of size (w, h) from (u, v) of the image bank img(0-2) 
    # to (x, y). If negative value is set for w and/or h, 
    # it will reverse horizontally and/or vertically. 
    # If colkey is specified, treated as transparent color
    pyxel.blt(player_x, player_y, IMAGE_BANK, 8, 0, 8, 8, 12)

    # draw the ground
    pyxel.blt(0, 9, IMAGE_BANK, 8, 8, 8, 8, 12)
    pyxel.blt(9, 9, IMAGE_BANK, 0, 8, 8, 8, 12)

    # draw the sun
    pyxel.blt(40, 10, IMAGE_BANK, 16, 0, 8, 8, 12)

    # draw some trees
    pyxel.blt(20, 0, IMAGE_BANK, 16, 8, 8, 8, 12)
    pyxel.blt(30, 0, IMAGE_BANK, 16, 8, 8, 8, 12)

# call update and draw function
pyxel.run(update, draw)