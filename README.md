# Spring Cloud Gateway + Authorization Server

This repository provides a playground for figuring out the "How To" for [this issue](https://github.com/spring-projects/spring-authorization-server/issues/564).

When an authenticated user requests `GET /rest/resource`, they should be redirected to `/login`, 
after they follow that flow they can request the resource again, and it should return their `Authentication.getName()`

I've left the `/authorization` project purposefully empty, as it is the main piece I'm unsure of.