from django.urls import include, path
from . import views

app_name='infractions'

urlpatterns = [
    # /infractions/ 
    path('', views.index, name='index'),

    # /infractions/71
]