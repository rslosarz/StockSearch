package com.slosarz.stocksearch.mock

import com.google.gson.Gson
import com.slosarz.stocksearch.model.SearchPictureResponse

object MockSearchPictureResponse {

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

    val mockPage1SearchPictureResponse: SearchPictureResponse =
        Gson().fromJson(page1Response, SearchPictureResponse::class.java)
}