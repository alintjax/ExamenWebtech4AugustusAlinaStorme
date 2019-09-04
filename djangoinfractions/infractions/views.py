from django.http import HttpResponse
from .models import Album
import json
from django.http import JsonResponse


def index(request):

    with open('infractions.json') as json_data:
        data = json.load(json_data)
        print(data)

    return JsonResponse(data)
