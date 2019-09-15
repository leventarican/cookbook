import pygame
from pygame.sprite import Sprite

class Enemy(Sprite):
    def __init__(self, game_space):
        super().__init__()
        self.screen = game_space.screen

        self.image = pygame.image.load('enemy.png')
        self.rect = self.image.get_rect()
        self.rect.x = self.rect.width
        self.rect.y = self.rect.height
        self.x = float(self.rect.x)
