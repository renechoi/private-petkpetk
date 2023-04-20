package com.petkpetk.service.domain.shopping.service.notuse;// package com.petkpetk.service.domain.shopping.service.notuse;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import javax.persistence.FetchType;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
//
// @Entity
// public class Article {
//
//     // ...
//
//     @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<ArticleImage> images = new ArrayList<>();
//
//     public void addImage(ArticleImage image) {
//         images.add(image);
//         image.setArticle(this);
//     }
//
//     public void removeImage(ArticleImage image) {
//         images.remove(image);
//         image.setArticle(null);
//     }
//
//     // ...
// }
//
// @Entity
// public class ArticleImage {
//
//     // ...
//
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "article_id")
//     private Article article;
//
//     // ...
// }
