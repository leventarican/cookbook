import pygame

pygame.init()

screenwidth = 500
screenheight = 500

win = pygame.display.set_mode((screenwidth, screenheight))
pygame.display.set_caption('the game')

width = 40
height = 60
x = 0
y = screenheight - height
vel = 20

clock = pygame.time.Clock()

isJump = False
jumpCount = 10

left = False
right = False
walkCount = 0

walk = [
pygame.image.load('run_0.png'),
pygame.image.load('run_1.png'),
pygame.image.load('run_2.png'),
pygame.image.load('run_3.png'),
pygame.image.load('run_4.png'),
pygame.image.load('run_5.png')
]
# jump = [
# pygame.image.load('jump_0.png'),
# pygame.image.load('jump_1.png'),
# pygame.image.load('jump_2.png'),
# pygame.image.load('jump_3.png')
# ]
bg = pygame.image.load('bg.jpg')

music = pygame.mixer.music.load("music.mp3")
pygame.mixer.music.play(-1)

def slice_sprite_sheet():
    images = []
    sprite_sheet = pygame.image.load('android.png').convert_alpha()
    sprite_sheet.set_colorkey((255, 0, 255))
    sprite_sheet_width, sprite_sheet_height = sprite_sheet.get_size()
    print('{}x{} pixels'.format(sprite_sheet_width, sprite_sheet_height))
    w = sprite_sheet_width/6
    h = sprite_sheet_height/6
    for i in range( int(sprite_sheet_width/w) ):
        images.append(sprite_sheet.subsurface((i*w, 0, w, h)))
    print(len(images))
    return images

def redraw():
    global walkCount

    win.blit(bg, (0,0))
    if walkCount + 1 >= 27:
        walkCount = 0

    # python 3: / for floating and // for int
    if left:
        win.blit(walk[walkCount//6], (x,y))
        walkCount += 1
    elif right:
        win.blit(walk[walkCount//6], (x,y))
        walkCount += 1
    else:
        #win.blit(char, (x, y))
        win.blit(walk[0], (x, y))
        walkCount = 0

    pygame.display.update()

#walk = slice_sprite_sheet()

# collision, events, ... in main loop
run = True
while run:
    clock.tick(27)

    for event in pygame.event.get():    # all events in pygame
        if event.type == pygame.QUIT:
            run = False

    # move
    # top left is 0,0 of coordinate system
    keys = pygame.key.get_pressed()    # list of keys
    if keys[pygame.K_LEFT] and x > vel:
        x-= vel
        left = True
        right = False
    elif keys[pygame.K_RIGHT] and x < screenwidth - width - vel:
        x+= vel
        left = False
        right = True
    else:
        left = False
        right = False
        walkCount = 0

    if not(isJump):
        if keys[pygame.K_SPACE]:
            isJump = True
            left = False
            right = False
            walkCount = 0
    else:
        if jumpCount >= -10:
            y -= (jumpCount * abs(jumpCount)) * 0.5
            jumpCount -= 1
        else:
            isJump = False
            jumpCount = 10

    redraw()

pygame.quit()
