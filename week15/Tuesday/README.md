## Concurrent architecture showcase - Google Chrome

Modern websites contain a lot of dynamic content and use JavaScript extensively to provide a rich browsing experience. Sadly, modern websites also tend to consume a lot of CPU and contain a lot of bugs. This wouldn't be a problem if browsers rendered one page at a time, but every contemporary browser provides so called tabs to open several websites at once. The problem with this is that if a single tab crashed, the entire browser crashes as well.

Google Chrome addresses this problem by using a multiprocess architecture, using three types of processes:
- Browser process

  The browser process is responsible for managing the user interface as
  well as disk and network I/O. A new browser process is created when
  Chrome is started. Only one browser process is created.

- Renderer process

  Renderer processes contain logic for rendering web pages - HTML, Javascript, images, and so on. As
  a general rule, a new renderer process is created for each website opened
  in a new tab, and so several renderer processes may be active at the same
  time.

- Plugin process

  A plugin process is created for each plugin in use.

The advantage of the multiprocess approach is that websites run in
isolation from one another. If one website crashes, only its renderer process
is affected, all other processes remain unharmed. Furthermore, renderer
processes run in a sandbox, which means that access to disk and network
I/O is restricted, minimizing the effects of any security exploits.

