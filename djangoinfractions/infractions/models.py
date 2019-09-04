from django.db import models

class Infraction(models.Model):
    id = models.IntegerField(max_length=1000)
    year = models.IntegerField(max_length=3000)
    month = models.IntegerField(max_length=12)
    date = models.IntegerField(max_length=31)
    street = models.CharField(max_length=250)
    driving_direction = models.CharField(max_length=250)
    speed_limit = models.CharField(max_length=250)
    passersby = models.CharField(max_length=10000)
    infractions_speed = models.CharField(max_length=200)
    infractions_red_light = models.CharField(max_length=200)


