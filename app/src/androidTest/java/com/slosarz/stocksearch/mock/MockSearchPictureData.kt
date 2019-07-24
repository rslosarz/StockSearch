package com.slosarz.stocksearch.mock

import com.google.gson.Gson
import com.slosarz.stocksearch.model.SearchPictureResponse

/**
 * Looks like duplicate of MockSearchPictureResponse from test package
 * but this is meant to be separate data sources for UI tests
 */
object MockSearchPictureData {

    private val page1Response = """
        {
    "page": 1,
    "per_page": 3,
    "total_count": 1088665,
    "search_id": "SEARCH_ID",
    "data": [
        {
            "id": "1296770323",
            "aspect": 1.499,
            "assets": {
                "preview": {
                    "height": 300,
                    "url": "https://image.shutterstock.com/display_pic_with_logo/91858/1296770323/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1296770323.jpg",
                    "width": 450
                },
                "small_thumb": {
                    "height": 67,
                    "url": "https://thumb1.shutterstock.com/thumb_small/91858/1296770323/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1296770323.jpg",
                    "width": 100
                },
                "large_thumb": {
                    "height": 100,
                    "url": "https://thumb1.shutterstock.com/thumb_large/91858/1296770323/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1296770323.jpg",
                    "width": 150
                },
                "huge_thumb": {
                    "height": 260,
                    "url": "https://image.shutterstock.com/image-photo/happy-womens-day-child-daughter-260nw-1296770323.jpg",
                    "width": 390
                },
                "preview_1000": {
                    "url": "https://ak.picdn.net/shutterstock/photos/1296770323/watermark_1000/05f912ddf6f596166eab0043ab66ff2c/preview_1000-1296770323.jpg",
                    "width": 1000,
                    "height": 667
                },
                "preview_1500": {
                    "url": "https://image.shutterstock.com/z/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1296770323.jpg",
                    "width": 1500,
                    "height": 1001
                }
            },
            "contributor": {
                "id": "91858"
            },
            "description": "Happy women's day! Child daughter is congratulating mom and granny giving them flowers tulips. Grandma, mum and girl smiling and hugging. Family holiday and togetherness.",
            "image_type": "photo",
            "has_model_release": false,
            "media_type": "image"
        },
        {
            "id": "1309297486",
            "aspect": 1.5,
            "assets": {
                "preview": {
                    "height": 300,
                    "url": "https://image.shutterstock.com/display_pic_with_logo/97565/1309297486/stock-photo-luxury-hotel-home-living-woman-relax-enjoying-sofa-furniture-of-outdoor-patio-beautiful-young-1309297486.jpg",
                    "width": 450
                },
                "small_thumb": {
                    "height": 67,
                    "url": "https://thumb1.shutterstock.com/thumb_small/97565/1309297486/stock-photo-luxury-hotel-home-living-woman-relax-enjoying-sofa-furniture-of-outdoor-patio-beautiful-young-1309297486.jpg",
                    "width": 100
                },
                "large_thumb": {
                    "height": 100,
                    "url": "https://thumb1.shutterstock.com/thumb_large/97565/1309297486/stock-photo-luxury-hotel-home-living-woman-relax-enjoying-sofa-furniture-of-outdoor-patio-beautiful-young-1309297486.jpg",
                    "width": 150
                },
                "huge_thumb": {
                    "height": 260,
                    "url": "https://image.shutterstock.com/image-photo/luxury-hotel-home-living-woman-260nw-1309297486.jpg",
                    "width": 390
                },
                "preview_1000": {
                    "url": "https://ak.picdn.net/shutterstock/photos/1309297486/watermark_1000/cb901350904ba71d59b92e3a63376e82/preview_1000-1309297486.jpg",
                    "width": 1000,
                    "height": 667
                },
                "preview_1500": {
                    "url": "https://image.shutterstock.com/z/stock-photo-luxury-hotel-home-living-woman-relax-enjoying-sofa-furniture-of-outdoor-patio-beautiful-young-1309297486.jpg",
                    "width": 1500,
                    "height": 1000
                }
            },
            "contributor": {
                "id": "97565"
            },
            "description": "Luxury hotel home living woman relax enjoying sofa furniture of outdoor patio. Beautiful young multiracial Asian girl relaxing day dreaming for rich early retirement in getaway tropical house.",
            "image_type": "photo",
            "has_model_release": false,
            "media_type": "image"
        },
        {
            "id": "1304896138",
            "aspect": 1.4993,
            "assets": {
                "preview": {
                    "height": 300,
                    "url": "https://image.shutterstock.com/display_pic_with_logo/91858/1304896138/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1304896138.jpg",
                    "width": 450
                },
                "small_thumb": {
                    "height": 67,
                    "url": "https://thumb9.shutterstock.com/thumb_small/91858/1304896138/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1304896138.jpg",
                    "width": 100
                },
                "large_thumb": {
                    "height": 100,
                    "url": "https://thumb9.shutterstock.com/thumb_large/91858/1304896138/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1304896138.jpg",
                    "width": 150
                },
                "huge_thumb": {
                    "height": 260,
                    "url": "https://image.shutterstock.com/image-photo/happy-womens-day-child-daughter-260nw-1304896138.jpg",
                    "width": 390
                },
                "preview_1000": {
                    "url": "https://ak.picdn.net/shutterstock/photos/1304896138/watermark_1000/a3d47879cfaddd5f3000efec115b89c2/preview_1000-1304896138.jpg",
                    "width": 1000,
                    "height": 667
                },
                "preview_1500": {
                    "url": "https://image.shutterstock.com/z/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1304896138.jpg",
                    "width": 1500,
                    "height": 1000
                }
            },
            "contributor": {
                "id": "91858"
            },
            "description": "Happy women's day! Child daughter is congratulating mom and granny giving them flowers tulips. Grandma, mum and girl smiling and hugging. Family holiday and togetherness.",
            "image_type": "photo",
            "has_model_release": false,
            "media_type": "image"
        }
    ]
}
    """.trimIndent()

    private val page2Response = """
        {
    "page": 2,
    "per_page": 3,
    "total_count": 1088665,
    "search_id": "SEARCH_ID",
    "data": [
        {
            "id": "1284992752",
            "aspect": 1.5,
            "assets": {
                "preview": {
                    "height": 300,
                    "url": "https://image.shutterstock.com/display_pic_with_logo/187633/1284992752/stock-photo-young-hispanic-family-sitting-on-sofa-reading-a-book-together-in-their-living-room-1284992752.jpg",
                    "width": 450
                },
                "small_thumb": {
                    "height": 67,
                    "url": "https://thumb9.shutterstock.com/thumb_small/187633/1284992752/stock-photo-young-hispanic-family-sitting-on-sofa-reading-a-book-together-in-their-living-room-1284992752.jpg",
                    "width": 100
                },
                "large_thumb": {
                    "height": 100,
                    "url": "https://thumb9.shutterstock.com/thumb_large/187633/1284992752/stock-photo-young-hispanic-family-sitting-on-sofa-reading-a-book-together-in-their-living-room-1284992752.jpg",
                    "width": 150
                },
                "huge_thumb": {
                    "height": 260,
                    "url": "https://image.shutterstock.com/image-photo/young-hispanic-family-sitting-on-260nw-1284992752.jpg",
                    "width": 390
                },
                "preview_1000": {
                    "url": "https://ak.picdn.net/shutterstock/photos/1284992752/watermark_1000/6c6fd2c65007fc04ca16f9ef6725670c/preview_1000-1284992752.jpg",
                    "width": 1000,
                    "height": 667
                },
                "preview_1500": {
                    "url": "https://image.shutterstock.com/z/stock-photo-young-hispanic-family-sitting-on-sofa-reading-a-book-together-in-their-living-room-1284992752.jpg",
                    "width": 1500,
                    "height": 1000
                }
            },
            "contributor": {
                "id": "187633"
            },
            "description": "Young Hispanic family sitting on sofa reading a book together in their living room",
            "image_type": "photo",
            "has_model_release": false,
            "media_type": "image"
        },
        {
            "id": "1292324956",
            "aspect": 1.4726,
            "assets": {
                "preview": {
                    "height": 305,
                    "url": "https://image.shutterstock.com/display_pic_with_logo/91858/1292324956/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1292324956.jpg",
                    "width": 450
                },
                "small_thumb": {
                    "height": 68,
                    "url": "https://thumb1.shutterstock.com/thumb_small/91858/1292324956/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1292324956.jpg",
                    "width": 100
                },
                "large_thumb": {
                    "height": 102,
                    "url": "https://thumb1.shutterstock.com/thumb_large/91858/1292324956/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1292324956.jpg",
                    "width": 150
                },
                "huge_thumb": {
                    "height": 260,
                    "url": "https://image.shutterstock.com/image-photo/happy-womens-day-child-daughter-260nw-1292324956.jpg",
                    "width": 384
                },
                "preview_1000": {
                    "url": "https://ak.picdn.net/shutterstock/photos/1292324956/watermark_1000/fdcfc5162ef954d392b58364c5c747c5/preview_1000-1292324956.jpg",
                    "width": 1000,
                    "height": 679
                },
                "preview_1500": {
                    "url": "https://image.shutterstock.com/z/stock-photo-happy-women-s-day-child-daughter-is-congratulating-mom-and-granny-giving-them-flowers-tulips-1292324956.jpg",
                    "width": 1500,
                    "height": 1019
                }
            },
            "contributor": {
                "id": "91858"
            },
            "description": "Happy women's day! Child daughter is congratulating mom and granny giving them flowers tulips. Grandma, mum and girl smiling and hugging. Family holiday and togetherness.",
            "image_type": "photo",
            "has_model_release": false,
            "media_type": "image"
        },
        {
            "id": "1212903172",
            "aspect": 1.5059,
            "assets": {
                "preview": {
                    "height": 298,
                    "url": "https://image.shutterstock.com/display_pic_with_logo/101595/1212903172/stock-photo-glasses-with-different-sorts-of-craft-beer-on-wooden-bar-tap-beer-in-pint-glasses-arranged-in-a-1212903172.jpg",
                    "width": 450
                },
                "small_thumb": {
                    "height": 66,
                    "url": "https://thumb9.shutterstock.com/thumb_small/101595/1212903172/stock-photo-glasses-with-different-sorts-of-craft-beer-on-wooden-bar-tap-beer-in-pint-glasses-arranged-in-a-1212903172.jpg",
                    "width": 100
                },
                "large_thumb": {
                    "height": 100,
                    "url": "https://thumb9.shutterstock.com/thumb_large/101595/1212903172/stock-photo-glasses-with-different-sorts-of-craft-beer-on-wooden-bar-tap-beer-in-pint-glasses-arranged-in-a-1212903172.jpg",
                    "width": 150
                },
                "huge_thumb": {
                    "height": 260,
                    "url": "https://image.shutterstock.com/image-photo/glasses-different-sorts-craft-beer-260nw-1212903172.jpg",
                    "width": 393
                },
                "preview_1000": {
                    "url": "https://ak.picdn.net/shutterstock/photos/1212903172/watermark_1000/97065897d06e66bd0252771eda67c250/preview_1000-1212903172.jpg",
                    "width": 1000,
                    "height": 664
                },
                "preview_1500": {
                    "url": "https://image.shutterstock.com/z/stock-photo-glasses-with-different-sorts-of-craft-beer-on-wooden-bar-tap-beer-in-pint-glasses-arranged-in-a-1212903172.jpg",
                    "width": 1500,
                    "height": 996
                }
            },
            "contributor": {
                "id": "101595"
            },
            "description": "Glasses with different sorts of craft beer on wooden bar. Tap beer in pint glasses arranged in a row. Closeup of five glasses of different types of draught beer in a pub.",
            "image_type": "photo",
            "has_model_release": false,
            "media_type": "image"
        }
    ]
}
    """.trimIndent()

    val mockPage1SearchPictureResponse: SearchPictureResponse =
        Gson().fromJson(page1Response, SearchPictureResponse::class.java)

    val mockPage2SearchPictureResponse: SearchPictureResponse =
        Gson().fromJson(page2Response, SearchPictureResponse::class.java)
}