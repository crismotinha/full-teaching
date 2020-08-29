from locust import HttpLocust, TaskSet, constant, task 
import random

class UserBehavior(TaskSet):
    
    headers = {
      'content-type': 'application/json',
    }

    @task()
    def create_user(self):
        email = "aluno{0}@gmail.com".format(random.randint(1,100000))
        payload = json.dumps([email,"P4ssw0rd!","Aluno","captcha"])
        res = self.client.post("/api-users/new", data=payload, headers=self.headers, verify=False)


class WebsiteUser(HttpLocust):
    task_set = UserBehavior
    wait_time = constant(1)