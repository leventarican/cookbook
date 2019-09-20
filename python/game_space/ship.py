import pygame

class Ship:
    def __init__(self, game_space):
        self.screen = game_space.screen
        self.screen_rect = game_space.screen.get_rect()
        self.image = pygame.image.load('ship.png')
        self.rect = self.image.get_rect()
        self.rect.midbottom = self.screen_rect.midbottom
        self.moving_right = False
        self.moving_left = False

    def update(self):
        if self.moving_right:
            if self.rect.right <= self.screen.get_rect().right:
                self.rect.x += 3
        if self.moving_left:
            if self.rect.left >= self.screen.get_rect().left:
                self.rect.x -= 3

    def blitme(self):
        # draw images on pygame surface
        self.screen.blit(self.image, self.rect)
