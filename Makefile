start:
	\
	docker pull selenoid/chrome:$(BROWSER_VERSION) && \
    docker-compose up --build --abort-on-container-exit --force-recreate
stop:
	\
	docker-compose down --rmi all && \
	docker rmi selenoid/chrome:$(BROWSER_VERSION)
setBrowserVersion:
	\
	sed -i -e 's/browser.version/$(BROWSER_VERSION)/g' 'browsers.json' && \
    cat browsers.json
