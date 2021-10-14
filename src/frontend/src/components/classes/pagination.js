export default class Pagination {
    currentPage = 0;
    allPages = [];
    constructor (allPages) {
      this.allPages = allPages
    }

    setCurrentPages (currentPage, allPages) {
      let selectedPages = []
      this.currentPage = currentPage
      let i = currentPage > 3 ? currentPage - 3 : 1
      for (i; i < i + 7; i++) {
        selectedPages.add(allPages[i])
      }
    }
}
