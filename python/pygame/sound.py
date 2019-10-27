import pygame
import sys
import time

# note: convert mp3 to ogg with: ffmpeg -i file.mp3 file.ogg

GREEN = (0, 255, 0)

# use that for soundeffect, ...
def play_sound():
    sound = pygame.mixer.Sound('algorithms-freemusicarchive.ogg')
    sound.play()
    time.sleep(1)
    sound.stop()

# use this for background music
def play_sound_background():
    pygame.mixer.music.load('algorithms-freemusicarchive.ogg')
    # -1: loop forever; 1 loop once, ...
    # 0.0: where to start (0.0 form beginning)
    pygame.mixer.music.play(-1, 0.0)
    pygame.mixer.music.stop()

def main():
    pygame.init()
    surface = pygame.display.set_mode([500, 500])

    # play_sound()
    play_sound_background()

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

if __name__ == "__main__":
    main()