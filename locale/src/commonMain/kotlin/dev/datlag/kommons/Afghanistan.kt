package dev.datlag.kommons

data object Afghanistan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AF")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("AFG")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(4)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(93)
}